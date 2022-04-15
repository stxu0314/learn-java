package .service.impl;

import .entity.TBlog;
import .dao.TBlogDao;
import .service.TBlogService;
import org.springframework.stereotype.Service;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;

import javax.annotation.Resource;

/**
 * (TBlog)表服务实现类
 *
 * @author makejava
 * @since 2022-04-10 21:05:06
 */
@Service("tBlogService")
public class TBlogServiceImpl implements TBlogService {
    @Resource
    private TBlogDao tBlogDao;

    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    @Override
    public TBlog queryById(Long id) {
        return this.tBlogDao.queryById(id);
    }

    /**
     * 分页查询
     *
     * @param tBlog 筛选条件
     * @param pageRequest      分页对象
     * @return 查询结果
     */
    @Override
    public Page<TBlog> queryByPage(TBlog tBlog, PageRequest pageRequest) {
        long total = this.tBlogDao.count(tBlog);
        return new PageImpl<>(this.tBlogDao.queryAllByLimit(tBlog, pageRequest), pageRequest, total);
    }

    /**
     * 新增数据
     *
     * @param tBlog 实例对象
     * @return 实例对象
     */
    @Override
    public TBlog insert(TBlog tBlog) {
        this.tBlogDao.insert(tBlog);
        return tBlog;
    }

    /**
     * 修改数据
     *
     * @param tBlog 实例对象
     * @return 实例对象
     */
    @Override
    public TBlog update(TBlog tBlog) {
        this.tBlogDao.update(tBlog);
        return this.queryById(tBlog.getId());
    }

    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 是否成功
     */
    @Override
    public boolean deleteById(Long id) {
        return this.tBlogDao.deleteById(id) > 0;
    }
}
