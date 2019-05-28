package com.karat.cn.controller.wx;

import com.karat.cn.controller.wx.integrate.IntegrateMember;
import com.karat.cn.controller.wx.vo.member.ResponseMember;
import com.karat.cn.controller.wx.vo.member.VoMemberData;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.web.bind.annotation.*;

/**
 * 请求接口
 */
@RestController
@RequestMapping("wx")
public class MemberController {

    @Autowired
    private MongoTemplate mongoTemplate;

    @RequestMapping("memberById")
    public ResponseMember memberById(String memberId){
        ResponseMember response=new ResponseMember();
        VoMemberData vo= IntegrateMember.findVoMemberData(memberId,mongoTemplate);
        response.setVoMemberData(vo);
        if(vo!=null){
            response.setCode("200");
            response.setMsg("请求成功");
        }else{
            response.setCode("201");
            response.setMsg("请求失败");
        }
        return response;
    }
}
