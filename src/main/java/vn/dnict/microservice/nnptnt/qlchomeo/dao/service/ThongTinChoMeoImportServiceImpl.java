package vn.dnict.microservice.nnptnt.qlchomeo.dao.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import vn.dnict.microservice.nnptnt.qlchomeo.dao.model.ThongTinChoMeoImport;

@Service
@Transactional
public class ThongTinChoMeoImportServiceImpl implements ThongTinChoMeoImportService{

	@Autowired
	ThongTinChoMeoImportRepo repo;
	@Override
	public ThongTinChoMeoImport save(ThongTinChoMeoImport entity) {
		// TODO Auto-generated method stub
		return repo.save(entity);
	}

	@Override
	public void deleteById(Long id) {
		// TODO Auto-generated method stub
		repo.deleteById(id);;
		
	}

	@Override
	public Optional<ThongTinChoMeoImport> findById(Long id) {
		// TODO Auto-generated method stub
		return repo.findById(id);
	}

	@Override
	public Page<ThongTinChoMeoImport> findAll(String search, Long thongTinChoMeoId, String trangThai, Pageable pageable) {
		// TODO Auto-generated method stub
		return repo.findAll(ThongTinChoMeoImportSpecifications.quickSearch(search, thongTinChoMeoId, trangThai), pageable);
	}

}
