package vn.dnict.microservice.utils;

import java.text.DecimalFormat;
import java.util.HashMap;

import org.apache.commons.lang.math.NumberUtils;

import lombok.extern.slf4j.Slf4j;
@Slf4j
public class ConvertMoney {

	private static final HashMap<String, String> hm_tien = new HashMap<String, String>() {
		/**
		 * 
		 */
		private static final long serialVersionUID = 7318304887204565L;

		{
			put("0", "không");
			put("1", "một");
			put("2", "hai");
			put("3", "ba");
			put("4", "bốn");
			put("5", "năm");
			put("6", "sáu");
			put("7", "bảy");
			put("8", "tám");
			put("9", "chín");
		}
	};
	private static final HashMap<String, String> hm_hanh = new HashMap<String, String>() {
		/**
		 * 
		 */
		private static final long serialVersionUID = -1223949905817477126L;

		{
			put("1", "đồng");
			put("2", "mươi");
			put("3", "trăm");
			put("4", "nghìn");
			put("5", "mươi");
			put("6", "trăm");
			put("7", "triệu");
			put("8", "mươi");
			put("9", "trăm");
			put("10", "tỷ");
			put("11", "mươi");
			put("12", "trăm");
			put("13", "nghìn");
			put("14", "mươi");
			put("15", "trăm");

		}
	};


	public String ChuyenSangChu(String x) {
		String kq = "";
		x = x.replace(",", "");
		System.out.println("x : " + x);
		String arr_temp[] = x.split(",");
		if (!NumberUtils.isNumber(arr_temp[0])) {
			return "";
		}
		String m = arr_temp[0];
		int dem = m.length();
		String dau = "";
		int flag10 = 1;
		while (!m.equals("") && !m.equals("0.0")) {
			if (m.length() <= 3 && m.length() > 1 && Long.parseLong(m) == 0) {

			} else {
				dau = m.substring(0, 1);
				if (dem % 3 == 1 && m.startsWith("1") && flag10 == 0) {
					kq += "mốt ";
					flag10 = 0;
				} else if (dem % 3 == 2 && m.startsWith("1")) {
					kq += "mười ";
					flag10 = 1;
				} else if (dem % 3 == 2 && m.startsWith("0") && m.length() >= 2 && !m.substring(1, 2).equals("0")) {
					// System.out.println("a "+m.substring(1, 2));
					kq += "lẻ ";
					flag10 = 1;
				} else {
					if (!m.startsWith("0")) {
						kq += hm_tien.get(dau) + " ";
						flag10 = 0;
					}
				}
				if (dem % 3 != 1 && m.startsWith("0") && m.length() > 1) {
				} else {
					if (dem % 3 == 2 && (m.startsWith("1") || m.startsWith("0"))) {// mười
					} else {
						kq += hm_hanh.get(dem + "") + " ";
					}
				}
			}
			m = m.substring(1);
			dem = m.length();
		}
		if(kq.length()>2) {
			kq = kq.substring(0, kq.length() - 1);
		}	
		return kq;
	}

	public String currencyFormat(String curr) {
		try {
			double vaelue = Double.parseDouble(curr);
			String pattern = "###,###";
			DecimalFormat myFormatter = new DecimalFormat(pattern);
			String output = myFormatter.format(vaelue);
			return output;
		} catch (NumberFormatException e) {
			log.debug("context", e);
		}
		return "";
	}
	
	public static String covertFloatMoneyToString(Float soTien) throws Exception {
		DecimalFormat dFormat = new DecimalFormat("####,###,###");
		String result = "0";
		if(soTien != null) {
			result = dFormat.format(soTien);
		} 
		return result;
	}
}
