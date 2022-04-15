package .service;

import .entity.TBlog;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;

/**
 * (TBlog)表服务接口
 *
 * @author makejava
 * @since 2022-04-10 21:05:05
 */
public interface TBlogService {

    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    TBlog queryById(Long id);

    /**
     * 分页查询
     *
     * @param tBlog 筛选条件
     * @param pageRequest      分页对象
     * @return 查询结果
     */
    Page<TBlog> queryByPage(TBlog tBlog, PageRequest pageRequest);

    /**
     * 新增数据
     *
     * @param tBlog 实例对象
     * @return 实例对象
     */
    TBlog insert(TBlog tBlog);

    /**
     * 修改数据
     *
     * @param tBlog 实例对象
     * @return 实例对象
     */
    TBlog update(TBlog tBlog);

    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 是否成功
     */
    boolean deleteById(Long id);

}
