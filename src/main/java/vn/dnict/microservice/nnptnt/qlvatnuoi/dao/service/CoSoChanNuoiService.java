package vn.dnict.microservice.nnptnt.qlvatnuoi.dao.service;

import java.util.Optional;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import vn.dnict.microservice.nnptnt.qlvatnuoi.dao.model.CoSoChanNuoi;

@Service
public interface CoSoChanNuoiService {
	public CoSoChanNuoi save(CoSoChanNuoi entity);

	public void deleteById(Long id);

	public Optional<CoSoChanNuoi> findById(Long id);
	
	public Optional<CoSoChanNuoi> findByTenCoSo(String tenCoSo);

	public Page<CoSoChanNuoi> findAll(String search, Long phuongXaId, Long quanHuyenId, Pageable pageable);
}