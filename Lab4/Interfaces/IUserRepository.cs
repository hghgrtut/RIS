namespace Lab7.Interfaces;

public interface IUserRepository : IRepository<User>
{
    Task<IEnumerable<User>> ReadAll();
}