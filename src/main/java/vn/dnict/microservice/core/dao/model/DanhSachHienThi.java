package vn.dnict.microservice.core.dao.model;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor(access = AccessLevel.PUBLIC)
public class DanhSachHienThi {
	private Long id;
	private String maDanhSach;
	private String tenCot;
	private String tenGiaTri;
	private Integer doRongCot;
	private Integer sapXep;
	private Boolean isHienThi;
	private Long caiDatHienThiId;
	private String nguoiSuDung;
}
