package com.app.services;

import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.app.entity.Category;
import com.app.entity.Railway;
import com.app.repository.RailwayRepository;

@Service
@Transactional
public class RailwayServiceImpl implements IRailwayService {

	@Autowired
	private RailwayRepository repo;
	
	@Autowired
	private ModelMapper mapper;
	
	@Override
	public Railway insert(Railway r) {
		return repo.save(r);
	}

	@Override
	public boolean update(Railway r) {
		if(repo.existsById(r.getId())) {
			repo.save(r);
			return true;
		}
		return false;
	}

	@Override
	public List<Railway> getallRailway() {
		return repo.findAll().stream().collect(Collectors.toList());
	}

	@Override
	public String delete(Long Id) {
		if(repo.existsById(Id))
		{
			repo.deleteById(Id);
			return "Successfully Deleted!";
		}
		return "Failed to delete...Invalid ID!!";
	}

	@Override
	public List<Railway> searchByCategory(Category cat) {
		
		return repo.searchByCat(cat);
	}

}
