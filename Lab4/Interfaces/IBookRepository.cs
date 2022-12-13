namespace Lab7.Interfaces;

public interface IBookRepository : IRepository<Book>, ITransactionRepository
{
    Task<IEnumerable<Book>> ReadAll();
}