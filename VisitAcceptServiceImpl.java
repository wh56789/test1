package com.onlinepowers.ubase.visitaccept.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.onlinepowers.ubase.visitaccept.mapper.VisitAcceptMapper;
import com.onlinepowers.ubase.visitaccept.model.comboBox.ComboBox;
import com.onlinepowers.ubase.visitaccept.model.domain.RRepairMaster;
import com.onlinepowers.ubase.visitaccept.model.domain.VisitAccept;

@Service("vistAcceptService")
public class VisitAcceptServiceImpl implements VisitAcceptService {
	
	@Autowired
	VisitAcceptMapper visitAcceptMapper;
	
	@Override
	public String getNoReceipt(VisitAccept visitAccept) {
		return visitAcceptMapper.getNoReceipt(visitAccept);
	}
	
	@Override
	@Transactional
	public void insertVisitAccept(Map Map) {
		visitAcceptMapper.insertVisitAccept(Map);
	}
	
	@Override
	public void updateVisitAcceptFile(Map map) {
		visitAcceptMapper.updateVisitAcceptFile(map);
	}
	
	@Override
	public VisitAccept getVisitAccept(VisitAccept visitAccept) {
		return visitAcceptMapper.getVisitAccept(visitAccept);
	}
	
	@Override
	@Transactional
	public void updateProcess(Map map) {

		switch (map.get("FGPDF").toString()) {
		case "1":
			// 접수 상태 업데이트
			visitAcceptMapper.updateVisitAccept(map);
			// pdf 유무 업데이트
			visitAcceptMapper.updateYnVisPdf(map);
			// pdf 경로 저장
		    visitAcceptMapper.insertPdfData(map);
			break;
		case "2":
			// pdf 유무 업데이트
			visitAcceptMapper.updateYnExiPdf(map);
			// pdf 경로 저장
			visitAcceptMapper.insertPdfData(map);
			break;
		case "3":
			// pdf 유무 업데이트
			visitAcceptMapper.updateYnRenPdf(map);
			// pdf 경로 저장
			visitAcceptMapper.insertPdfData(map);
			break;
		case "4":
			// pdf 유무 업데이트
			visitAcceptMapper.updateYnEstPdf(map);
			// pdf 경로 저장
			visitAcceptMapper.insertPdfData(map);
			break;
		case "5":
			// pdf 유무 업데이트
			visitAcceptMapper.updateYnRepPdf(map);
			// pdf 경로 저장
			visitAcceptMapper.insertPdfData(map);
			break;

		default:
			break;
		}
		
		// 여기 나중에 접수중 상태 업데이트,pdf 경로 insert
		//visitAcceptMapper.updateAsMst(visitAccept);
	}
	
	@Override 
	public int noSeqDuplicated(VisitAccept visitAccept) {
		return visitAcceptMapper.noSeqDuplicated(visitAccept);
	}
	
	@Override
	public void setUser(VisitAccept visitAccept) {
		visitAcceptMapper.updateSvcNo(visitAccept);
		visitAcceptMapper.setUser(visitAccept);
	}

	@Override
	public List comboBoxSelect(String cdMaster) {
		List result =  visitAcceptMapper.comboBoxSelect(cdMaster);
		return result;
	}

	@Override
	public List comboBoxSelectValue(Map map) {
		List result =  visitAcceptMapper.comboBoxSelectValue(map);
		return result;
	}
	public List issueCommboBox(Map map) {
		List result =  visitAcceptMapper.comboBoxIssueValue(map);
		return result;
	}
	
	@Override
	public List getRRepairMaster(RRepairMaster rRepairMaster) {
	//	RRepairMaster master =visitAcceptMapper.getRRepairMaster(rRepairMaster);
		return visitAcceptMapper.getRRepairMaster(rRepairMaster);
	}
	// 수리 내역서 자재 가져오기
	@Override
	public Map getPriseList(Map map) {
		List list = visitAcceptMapper.getPriseList(map);
		List listCount =  visitAcceptMapper.getPriseListCount(map);
		HashMap ListCount = (HashMap) listCount.get(0);
		Map<String, String> result = new HashMap<String, String>();
		int listCountValue = Integer.parseInt(ListCount.get("COUNT").toString());
		List getPriseList = visitAcceptMapper.getPriseList(map);
		List getPriseListRemainder = visitAcceptMapper.getPriseListRemainder(map);
			//자재가 7가지가 넘을 경우 마지막 행에 나머지 내용 표시
			if(listCountValue>7)
			{
				for (int i = 0; i < 7; i++) {
					HashMap mapLIst = (HashMap) getPriseList.get(i);
					result.put("cdItemList" + i, mapLIst.get("CDITEM").toString());
					result.put("nmItemList" + i, mapLIst.get("NMITEM").toString());
					result.put("count" + i, mapLIst.get("COUNT").toString());
					result.put("vat" + i,mapLIst.get("VAT").toString() );
					result.put("upStockCs" + i,mapLIst.get("UPSTOCKCS").toString() );
				}
				HashMap mapLIstRemainder = (HashMap) getPriseListRemainder.get(0);
				result.put("cdItemList6", mapLIstRemainder.get("CDITEM").toString());
				result.put("nmItemList6", mapLIstRemainder.get("NMITEM").toString());
				result.put("count6", mapLIstRemainder.get("COUNT").toString());
				result.put("vat6",mapLIstRemainder.get("VAT").toString() );
				result.put("upStockCs6",mapLIstRemainder.get("UPSTOCKCS").toString() );
			}else
			{
				
				//자재가 7가지가 안넘는 경우
				int nullCount =getPriseList.size();
				for (int i = 0; i < getPriseList.size(); i++) {
					HashMap mapLIst = (HashMap) getPriseList.get(i);
					result.put("cdItemList" + i, mapLIst.get("CDITEM").toString());
					if(mapLIst.get("NMITEM")!=null)
					{
						result.put("nmItemList" + i, mapLIst.get("NMITEM").toString());
					}else
					{
						result.put("nmItemList" + i, "");
					}
					
					result.put("count" + i, mapLIst.get("COUNT").toString());
					result.put("vat" + i,mapLIst.get("VAT").toString() );
					result.put("upStockCs" + i,mapLIst.get("UPSTOCKCS").toString() );
				}
				// pdf 에 나머지 값이 null로 뜨는 것을 방지하기 위함
				for (int i = nullCount; i <= 7; i++) {

					result.put("cdItemList" + i, "");
					result.put("nmItemList" + i,"");
					result.put("count" + i,"");
					result.put("vat" + i,"");
					result.put("upStockCs" + i,"");
				}
				
			}

		return result;
	}

	// 견적 확인서에 가격을 가져오기 위함
	@Override
	public Map selectCdEee(Map map) {
		String noSerial =  map.get("noSerial").toString();
		int noSerialLength =noSerial.length();
		
		String cdEee = noSerial.substring(noSerialLength-4);
		map.put("cdEee", cdEee);
		System.out.println("cdEee ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~ : " + cdEee);
		List list = visitAcceptMapper.selectCdEee(map);
		Map result = new HashMap();
		if(list.size()>0)
		{
			HashMap hashMap = (HashMap)list.get(0);
			
			result.put("amtDp", String.format("%,d", Integer.parseInt(hashMap.get("AMTDP").toString())) );
			result.put("amtDk", String.format("%,d", Integer.parseInt(hashMap.get("AMTDK").toString())) );
			System.out.println("amtDp ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~ : " + String.format("%,d", Integer.parseInt(hashMap.get("AMTDP").toString())));
			System.out.println("amtDk ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~ : " + String.format("%,d", Integer.parseInt(hashMap.get("AMTDK").toString())));
			
		}else
		{
			result.put("amtDp", "0");
			result.put("amtDk", "0");
		}
		return result;
	}
	
	@Override
	public Map selectRenParam(Map map) 
	{
		Map result = new HashMap();
		List list = visitAcceptMapper.selectPdfNoSeq(map);
		List itemParam =  visitAcceptMapper.selectRenParam(map);

		HashMap hashMap = (HashMap) list.get(0);
		result.put("pdfNoSeq", hashMap.get("PDFSEQ"));
		
		
		
		if(itemParam.size()>0)
		{
			HashMap itemParamHashMap = (HashMap) itemParam.get(0);
			if(itemParamHashMap.get("NMITEM")!=null){result.put("nmItem", itemParamHashMap.get("NMITEM"));}else{result.put("nmItem","");}
			if(itemParamHashMap.get("NOSERIAL")!=null){result.put("noSerial", itemParamHashMap.get("NOSERIAL"));}else{result.put("noSerial","");}
		}else
		{
			result.put("nmItem","");
			result.put("noSerial","");
		}
		
		return result;
	}

}
