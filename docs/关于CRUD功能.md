# CRUD
- 本框架提供了基本的增删该查的功能：
- 主要实现在ejpa：vip.efactory.ejpa.base包里

# 分页及排序
public R getByPage(Pageable page) {...},使用jpa默认的分页对象，后面可能考虑不使用这个，这个对象太繁杂了。

# 通过主键获取记录
public R getById(Long id) {...}

# 保存记录
public R save(T1 entity) {...} ，如果实体上有注解校验约束，则会被检查！

# 更新记录
public R updateById(T1 entity) {...}，如果实体上有注解校验约束，则会被检查！

# 通过主键删除记录
public R deleteById(Long id) {...}

更多具体的实现，参见：vip.efactory.ejpa.base.controller.BaseController类

注意：因为继承BaseController 会默认已经注入了Service层，如果不想使用父类的实现，可以使用entityService对象调用服务层的方法！