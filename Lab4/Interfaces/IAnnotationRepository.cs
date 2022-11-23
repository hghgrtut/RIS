namespace Lab7.Interfaces;

public interface IAnnotationRepository : IRepository<Annotation>, ITransactionRepository
{
    Task<IEnumerable<Annotation>> ReadAll();
    Task<Annotation> ReadByBookId(Guid bookId);
}