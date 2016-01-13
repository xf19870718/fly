/*package sample.ssm.alo;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import sample.ssm.bso.SSMBSO2;
import sample.ssm.dto.ResultDTO;

import com.linktech.mybatis.model.BeEnterprise;

@RestController
@Scope("prototype")
@RequestMapping("/ssm")
public class SSMALO {
	
	@Autowired
	protected ResultDTO resultDTO;
	
	@Autowired
	protected SSMBSO2 ssmBSO2;
	
	@RequestMapping("/test")
	public String test(){
		System.out.println("ssss");
		return "{\"sss\":\"ddd\"}";
	}
	
	@RequestMapping("/insert")
	public ResultDTO insert(BeEnterprise en) throws Exception{
		ssmBSO2.insert(en);
		resultDTO.setResult(1);
		return resultDTO;
	}
	
	@RequestMapping("/update")
	public ResultDTO update(BeEnterprise en) throws Exception{
		ssmBSO2.update(en);
		resultDTO.setResult(1);
		return resultDTO;
	}
	
	@RequestMapping("/delete")
	public ResultDTO delete(String id) throws Exception{
		ssmBSO2.delete(id);
		resultDTO.setResult(1);
		return resultDTO;
	}
	
	@RequestMapping("/view")
	public BeEnterprise view(String id) throws Exception{
		BeEnterprise enterprise = ssmBSO2.findOne(id);
		resultDTO.setResult(1);
		return enterprise;
	}
	
	@RequestMapping("/edit")
	public ResultDTO find(String id) throws Exception{
		BeEnterprise enterprise = ssmBSO2.findOne(id);
		resultDTO.setResult(1);
		resultDTO.setData(enterprise);
		return resultDTO;
	}
	
	@RequestMapping("/query")
	public ResultDTO findAll() throws Exception{
		List<BeEnterprise> list = ssmBSO2.findAll();
		resultDTO.setResult(1);
		resultDTO.setDataRows(list);
		resultDTO.setNowPage(1);
		resultDTO.setTotalPage(10);
		return resultDTO;
	}
	
}
*/