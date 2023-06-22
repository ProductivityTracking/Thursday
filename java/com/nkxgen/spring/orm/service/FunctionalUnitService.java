package com.nkxgen.spring.orm.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nkxgen.spring.orm.dao.FunctionalunitDAO;
import com.nkxgen.spring.orm.model.FunctionalUnit;
import com.nkxgen.spring.orm.model.FunctionalUnitdto;
import com.nkxgen.spring.orm.model.FunctionalUnitinput;

@Service
@Transactional
public class FunctionalUnitService {
	private final FunctionalunitDAO funitDao;

	@Autowired
	public FunctionalUnitService(FunctionalunitDAO funitDAO) {
		this.funitDao = funitDAO;
	}

	public List<FunctionalUnitdto> getFunctionalunitByModId(Integer modId) {
		return funitDao.getFunctionalunitByModId(modId);
	}
	
	

	  
	   public void createFunit(FunctionalUnitinput funitinput) {
		 // Additional business logic, if needed
		
		 FunctionalUnit funit = funitinput.toEntity();
		 funitDao.save(funit);
		
		 }
	  

	// public void createFunit(FunitInput funitinput) {
	// // Additional business logic, if needed
	//
	// FunctionalUnit funit = funitinput.toEntity();
	// funitDao.save(funit);
	//
	// }

}
