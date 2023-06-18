package com.ruoyi.web.controller.system;

import com.ruoyi.common.core.controller.BaseController;
import com.ruoyi.common.core.domain.AjaxResult;
import com.ruoyi.common.core.domain.entity.SysUser;
import com.ruoyi.system.domain.FVisit;
import com.ruoyi.system.domain.User;
import com.ruoyi.system.service.IFVisitService;
import com.ruoyi.system.service.ISysUserService;
import org.apache.commons.collections.CollectionUtils;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

/**
 * 文件Controller
 *
 * @author ruoyi
 * @date 2023-06-04
 */
@RestController
@RequestMapping("/doc/statistics")
public class FStatisticsController  extends BaseController {
    @Autowired
    private IFVisitService visitService;

    @Autowired
    private ISysUserService userService;

    /**
     * 查询文件列表
     */
    //@PreAuthorize("@ss.hasPermi('doc:statistics:list')")
    @GetMapping("/list")
    public AjaxResult statistics(FVisit fVisit) {
        List<SysUser> userList = userService.selectUserList(new SysUser());
        List<User> users = new ArrayList<>();
        if(CollectionUtils.isNotEmpty(userList)){
            for(SysUser u:userList){
                FVisit v = new FVisit();
                v.setDocId(u.getUserId());
                v.setVisitTime(fVisit.getVisitTime());
                List<FVisit> visitList = visitService.selectFVisitList(v);
                User user = new User();
                BeanUtils.copyProperties(u,user);
                user.setVisitList(visitList);
                users.add(user);
            }
        }
        return AjaxResult.success(users);
    }
}
