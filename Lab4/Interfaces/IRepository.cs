
namespace Lab7.Interfaces;

public interface IRepository<T>
{
    Task<T> Create(T entity);
    Task<T> Read(Guid id);
    Task<T> Update(Guid id, T entity);
    Task Delete(Guid id);
}