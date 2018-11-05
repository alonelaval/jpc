package com.alonelaval;



import java.util.List;
import java.util.Optional;

/**
 * @author huawei
 * @create 2018-07-12
 **/

public abstract class AbstractBaseService<T,PK> implements IBaseService<T,PK> {
    @Transactional(rollbackFor = Exception.class)
    @Override
    public T add(T t) throws Exception {
        return  getBaseDao().addEntity(t);
    }
    @Transactional(rollbackFor = Exception.class)
    @Override
    public T update(T t) throws Exception {
        return getBaseDao().update(t);

    }
    @Override
    public Optional<T> findById(PK id) throws Exception {
        return  getBaseDao().findById(id);
    }

    @Override
    public Page<T> findByModelAndPage(Model model, Page<T> page)throws Exception{

        return  getBaseDao().findAllByPredicateAndPage(WhereBuilder.build().predicate(),page);
    }
    @Transactional(rollbackFor = Exception.class)
    @Override
    public void disable(List<Integer> ids) throws Exception {
        updateState(State.DISABLED,ids);
    }
    @Transactional(rollbackFor = Exception.class)
    @Override
    public void enable(List<Integer> ids) throws Exception {
        updateState(State.ENABLED,ids);
    }
    @Transactional(rollbackFor = Exception.class)
    @Override
    public void delete(List<Integer> ids) throws Exception {
        updateState(State.DELETE,ids);
    }

    private void updateState(State state, List<Integer> ids)throws  Exception{
        if(Optional.ofNullable(ids).isPresent()){
            getBaseDao().updateState(state,ids);
        }
    }

    @Override
    public List<T> listAll(Model model) throws Exception {

        return getBaseDao().listAll(WhereBuilder.build().predicate());
    }

    @Override
    public List<T> saveAll(Iterable<T> iterable) throws Exception {
        return getBaseDao().saveAll(iterable);
    }

    @Override
    public T update(Model model, PK pk) throws Exception {

        throw  new NotImplementedException("没有实现！");
    }


    @Override
    public T add(Model model) throws Exception {
        throw  new NotImplementedException("没有实现！");
    }

    @Override
    public List<T> findAllByIds(List<PK> pks) throws Exception {
        return getBaseDao().findAllByIds(pks);
    }

    /**
     * 抽象类
     * @return
     */
    protected abstract IBaseDao<T,PK> getBaseDao();
}
