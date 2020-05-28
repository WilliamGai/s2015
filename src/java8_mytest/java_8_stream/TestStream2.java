package java8_mytest.java_8_stream;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import com.alibaba.fastjson.JSON;

/**
 * 
 * @author gbn
 *
 */
public class TestStream2 {
    public static void main(String args[]){
    	SkuBarcodeDto s1 = new SkuBarcodeDto(1, (short)2, "a");
    	SkuBarcodeDto s2 = new SkuBarcodeDto(1, (short)1, "a");
    	SkuBarcodeDto s3 = new SkuBarcodeDto(1, (short)1, "b");
    	SkuBarcodeDto s4 = new SkuBarcodeDto(1, (short)1, "c");
    	SkuBarcodeDto s5 = new SkuBarcodeDto(2, (short)1, "A");
    	SkuBarcodeDto s6 = new SkuBarcodeDto(2, (short)1, "B");
    	List<SkuBarcodeDto> list = Arrays.asList(s1, s2, s3, s4, s5, s6);
    	Map<Integer,String> map = list.stream().collect(Collectors.toMap(SkuBarcodeDto::getSkuCode, SkuBarcodeDto::getBarcode, (oldValue, newValue)->oldValue+"/"+newValue, LinkedHashMap::new));

    	//不行
    	
		Map<Integer, List<String>> map2 = list.collect(Collectors.partitioningBy(SkuBarcodeDto::getSkuCode));

    	Map<Integer,List<String>> map3 = new HashMap<>();
    	list.forEach(dto->{
    		map3.computeIfAbsent(dto.getSkuCode(), (k)-> new ArrayList<String>()).add(dto.getBarcode());
    	});
    	Map<Integer,String> map2 = list.stream().collect(Collectors.toMap(SkuBarcodeDto::getSkuCode, SkuBarcodeDto::getBarcode, (oldValue, newValue)->oldValue+"/"+newValue, LinkedHashMap::new));

//    	Map<Integer,String> map = list.stream().filter(dto->dto.getType()!=2).collect(Collectors.groupingBy(SkuBarcodeDto::getSkuCode, sto->sto.));
        System.out.println(JSON.toJSONString(map));
    }
    public static class SkuBarcodeDto{
    	private Integer skuCode;
    
        private Short type;
        
        private String barcode;

        public SkuBarcodeDto(){}
        
		public SkuBarcodeDto(Integer skuCode, Short type, String barcode) {
			super();
			this.skuCode = skuCode;
			this.type = type;
			this.barcode = barcode;
		}

		public Integer getSkuCode() {
			return skuCode;
		}

		public void setSkuCode(Integer skuCode) {
			this.skuCode = skuCode;
		}

		public Short getType() {
			return type;
		}

		public void setType(Short type) {
			this.type = type;
		}

		public String getBarcode() {
			return barcode;
		}

		public void setBarcode(String barcode) {
			this.barcode = barcode;
		}
        
        
    }

}
