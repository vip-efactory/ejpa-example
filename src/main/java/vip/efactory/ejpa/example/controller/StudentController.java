package vip.efactory.ejpa.example.controller;

import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.beans.BeanUtils;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.web.bind.annotation.*;
import vip.efactory.ejpa.base.controller.BaseController;
import vip.efactory.ejpa.base.entity.BaseSearchEntity;
import vip.efactory.ejpa.example.entity.Student;
import vip.efactory.ejpa.example.service.IStudentService;
import vip.efactory.ejpa.utils.R;

@RestController
@RequestMapping("/student")
public class StudentController extends BaseController<Student, IStudentService, Long> {

    /**
     * Description: 默认的分页与排序
     *
     * @param page 分页参数对象
     * @return vip.efactory.ejpa.utils.R
     * @author dbdu
     */
    @ApiOperation(value = "获取分页数据", notes = "默认每页25条记录,id字段降序")
    @RequestMapping(value = "/page", method = {RequestMethod.GET})
    public R getByPage(@PageableDefault(value = 25, sort = {"id"}, direction = Sort.Direction.DESC) Pageable page) {
        return super.getByPage(page);
    }

    /**
     * Description: 高级查询
     *
     * @param baseSearchEntity 含有高级查询条件
     * @param page             分页参数对象
     * @return vip.efactory.ejpa.utils.R
     * @author dbdu
     */
    @ApiOperation(value = "多条件组合查询,返回分页数据", notes = "默认每页25条记录,id字段降序")
    @RequestMapping(value = "/advanced/query", method = {RequestMethod.POST})
    public R advancedQuery(@RequestBody BaseSearchEntity baseSearchEntity, @PageableDefault(value = 25, sort = {"id"}, direction = Sort.Direction.DESC) Pageable page) {
        Student entity = new Student();
        BeanUtils.copyProperties(baseSearchEntity, entity);
        return super.advancedQueryByPage(page, entity);
    }

    /**
     * Description:多字段模糊查询,例如:
     * http://frms.ddbin.com:8080/carton/fuzzy?fields=name,version&q=BB
     *
     * @param page   分页参数对象
     * @param q      模糊查询的值
     * @param fields 要查询的字段
     * @return vip.efactory.ejpa.utils.R
     * @author dbdu
     */
    @ApiOperation(value = "多字段模糊查询,例如:q=abc&fields=name,address,desc", notes = "多个字段模糊匹配")
    @RequestMapping(value = "/fuzzy", method = {RequestMethod.GET})
    public R getByPage(@RequestParam String q, @RequestParam String fields, @PageableDefault(value = 25, sort = {"id"}, direction = Sort.Direction.DESC) Pageable page) {
        return super.queryMutiField(q, fields, page);
    }


    /**
     * Description:使用id来获取实体
     *
     * @param id 主键
     * @return vip.efactory.ejpa.utils.R
     * @author dbdu
     */
    @GetMapping("/{id}")
    @ApiOperation(value = "依据Id来获取对应的记录", notes = "依据Id来获取对应的记录")
    public R getById(@PathVariable("id") Long id) {
        return super.getById(id);
    }


    /**
     * Description:保存实体
     *
     * @param entity 要保存的对象实体
     * @return vip.efactory.ejpa.utils.R
     * @author dbdu
     */
    @PostMapping
    @ApiOperation(value = "保存记录", notes = "保存学生实体")
    public R save( @RequestBody @ApiParam(name = "entity", value = "Json格式", required = true) Student entity) {
        return super.save(entity);
    }

    /**
     * Description:更新
     *
     * @param entity 更新对象
     * @return vip.efactory.ejpa.utils.R
     * @author dbdu
     */
    @PutMapping
    @ApiOperation(value = "依据Id来更新对应的记录", notes = "依据Id来更新对应的记录,属性值为空则不更新数据表中已有的数据")
    public R updateById(@RequestBody @ApiParam(name = "entity", value = "Json格式", required = true) Student entity) {
        return super.updateById(entity);
    }

    /**
     * Description: 依据id来删除实体
     *
     * @param id 主键
     * @return vip.efactory.ejpa.utils.R
     * @author dbdu
     */
    @DeleteMapping("/{id}")
    @ApiOperation(value = "依据Id来删除对应的记录", notes = "依据Id来删除对应的记录")
    public R deleteById(@PathVariable Long id) {
        return super.deleteById(id);
    }

}
