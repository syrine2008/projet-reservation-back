package com.example.tpSpring.serviceImp;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.tpSpring.Repository.CommentaireRepository;
import com.example.tpSpring.Repository.TravelRepository;
import com.example.tpSpring.dto.FilterTravelDto;
import com.example.tpSpring.dto.TravelDto;
import com.example.tpSpring.dto.UserDto;
import com.example.tpSpring.mapper.TravelMapper;
import com.example.tpSpring.mapper.UserMapper;
import com.example.tpSpring.model.Travel;
import com.example.tpSpring.service.TravelService;
import com.example.tpSpring.singleton.Singleton;

@Service
public class TravelServiceImp implements TravelService {

	@Autowired
	private TravelRepository travelRepository;
	@Autowired
	private TravelMapper travelMapper;
	@Autowired
	private UserMapper userMapper ;
	@Autowired
	private CommentaireRepository commentaireRepository;
	
	Singleton singleton = Singleton.getInstance();

	@Override
	public TravelDto getTravelById(int id) {
		Optional<Travel> optionalTravel = travelRepository.findById(id);
		if (optionalTravel.isPresent()) {
			return travelMapper.toDto(optionalTravel.get());
		} else {
			return null;
		}
	}

	@Override
	public void createTravel(TravelDto td) {
		travelRepository.save(travelMapper.toEntity(td));

	}

	@Override
	public List<TravelDto> getAllTravel() {

		return travelRepository.findAll().stream().map(travel -> travelMapper.toDto(travel))
				.collect(Collectors.toList());
	}

	@Override
	public List<TravelDto> getFiltredTravel(List<FilterTravelDto> filters) {
		
		
		StringBuilder sqlBuilder = new StringBuilder("select * from travel ");
		Statement statement;
		ResultSet resultSet;
		List<TravelDto> result = new ArrayList<TravelDto>() ;
		
		try {
			if (filters.isEmpty()) {
				statement = singleton.getConnection().createStatement();
				resultSet = statement.executeQuery(sqlBuilder.toString());
			} else {
				sqlBuilder.append(" where ");
				int index = 0;
				for (FilterTravelDto filter : filters) {

					
					if (index > 0) {
						sqlBuilder.append(" and ");
					}

					sqlBuilder.append(filter.getColumn() + " like '%" + filter.getValue() + "%'");
					
					index++;
				};

				statement = singleton.getConnection().createStatement();
				resultSet = statement.executeQuery(sqlBuilder.toString());

			}

			while (resultSet.next()) {
				TravelDto td = new TravelDto(); 
				
				td.setId(resultSet.getInt("id"));
				td.setName(resultSet.getString("name"));
				td.setDescription(resultSet.getString("description"));
				td.setDeparture(resultSet.getString("departure"));
				td.setDestination(resultSet.getString("destination"));
				td.setVille(resultSet.getString("ville"));
				td.setType(resultSet.getString("type"));
				td.setStartDate(resultSet.getDate("start_date"));
				td.setEndDate(resultSet.getDate("end_date"));
				td.setPrice(resultSet.getLong("price"));
				td.setNbPlace(resultSet.getInt("nb_place"));
				td.setDisponibility(resultSet.getString("disponibility"));
				td.setUrlImage(resultSet.getString("url_image"));
				td.setNote(commentaireRepository.calCalculSommesDesNotes(resultSet.getInt("id")).get());
				td.setCommentaires(commentaireRepository.getCommantaireByTravelId(resultSet.getInt("id")).get());
				result.add(td); 
				
				
		
			}

			

		} catch (SQLException e) {

			e.printStackTrace();
		}
		return result;
	}

	@Override
	public List<String> getAllDestinatioins() {
		
		return travelRepository.getAllDestinations();
	}

	@Override
	public List<TravelDto> getTravelByOwnerId(UserDto u) {
		
		return travelRepository.getTravelByOwnerId(userMapper.toEntity(u)).stream()
				.map(travel -> travelMapper.toDto(travel))
				.collect(Collectors.toList());
	}

	@Override
	public void deleteTravelByid(int id) {
		travelRepository.deleteById(id);
	}

}
