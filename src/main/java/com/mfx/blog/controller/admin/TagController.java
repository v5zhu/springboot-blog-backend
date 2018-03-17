package com.mfx.blog.controller.admin;

import com.mfx.blog.component.constant.WebConst;
import com.mfx.blog.controller.BaseController;
import com.mfx.blog.dto.MetaDto;
import com.mfx.blog.dto.Types;
import com.mfx.blog.modal.bo.RestResponseBo;
import com.mfx.blog.modal.entity.MetaDO;
import com.mfx.blog.service.MetaService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.util.List;

/**
 * @author 13
 * @date 2017/2/21
 */
@Controller
@RequestMapping("admin/tag")
public class TagController extends BaseController {

    private static final Logger LOGGER = LoggerFactory.getLogger(TagController.class);

    @Resource
    private MetaService metasService;

    @GetMapping(value = "list.token")
    @ResponseBody
    public ResponseEntity tags() {
        List<MetaDto> tags = metasService.getMetaList(Types.TAG.getType(), null, WebConst.MAX_POSTS);
        return new ResponseEntity(RestResponseBo.ok(tags), HttpStatus.OK);
    }

    @GetMapping(value = "list.open")
    @ResponseBody
    public ResponseEntity tagList() {
        List<MetaDto> tags = metasService.getMetaList(Types.TAG.getType(), null, WebConst.MAX_POSTS);
        return new ResponseEntity(RestResponseBo.ok(tags), HttpStatus.OK);
    }

    @PostMapping(value = "save")
    @ResponseBody
    public RestResponseBo saveTag(@RequestBody MetaDO meta) {
        try {
            metasService.saveMeta(Types.TAG.getType(), meta.getName(), meta.getId());
        } catch (Exception e) {
            String msg = "标签保存失败";
            LOGGER.error(msg, e);
            return RestResponseBo.fail(msg);
        }
        return RestResponseBo.ok();
    }
}