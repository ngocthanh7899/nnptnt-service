package vn.dnict.microservice.nnptnt.qlvatnuoi.dao.service;

import java.time.LocalDate;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import vn.dnict.microservice.nnptnt.qlvatnuoi.dao.model.HoatDongChanNuoi;

@Service
@Transactional
public class HoatDongChanNuoiServiceImpl implements  HoatDongChanNuoiService{
	@Autowired
	HoatDongChanNuoiRepo repo;
	
	@Override
	public HoatDongChanNuoi save(HoatDongChanNuoi entity) {
		// TODO Auto-generated method stub
		return repo.save(entity);
	}

	@Override
	public void deleteById(Long id) {
		// TODO Auto-generated method stub
		repo.deleteById(id);;
		
	}
	
	public Optional<HoatDongChanNuoi> findById(Long id) {
		// TODO Auto-generated method stub
		return repo.findById(id);
	}




	
	@Override
	public Page<HoatDongChanNuoi> findAll(String search, Integer donViTinh, Integer soLuongNuoi,
			String mucDichNuoi, LocalDate thoiGianBatDauNuoi, LocalDate thoiGianXuat, Integer slVatNuoiXuat,
			Float sanLuongXuat, String ghiChu, Long loaiVatNuoiId, Long namChanNuoiId,Long coSoChanNuoiId,
			Pageable pageable) {
		// TODO Auto-generated method stub
		return repo.findAll(HoatDongChanNuoiSpecifications.quickSearch(search,donViTinh,soLuongNuoi,
				mucDichNuoi,thoiGianBatDauNuoi,thoiGianXuat,slVatNuoiXuat,sanLuongXuat,ghiChu, loaiVatNuoiId,
				namChanNuoiId,coSoChanNuoiId), pageable);
	}

	
	
	
	



	



	




}
