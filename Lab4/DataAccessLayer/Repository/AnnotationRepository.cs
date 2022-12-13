using Lab7.DataAccessLayer.Transaction;
using Microsoft.EntityFrameworkCore;

namespace Lab7.DataAccess.Repositories;

public class AnnotationRepository : IAnnotationRepository
{
    private readonly AnnotationDbContext _context;
    private DbSet<Annotation> Annotations => _context.Annotations;

    public AnnotationRepository(AnnotationDbContext context)
    {
        _context = context;
    }

    public async Task<Annotation> Create(Annotation annotation)
    {
        var createdEntity = await Annotations.AddAsync(annotation);
        await Save();
        return createdEntity.Entity;
    }

    public Task<Annotation> Read(Guid id)
    {
        return Annotations.FirstOrDefaultAsync(user => user.Id.Equals(id));
    }

    public async Task Delete(Guid id)
    {
        Annotation deletedAnnotation = await Read(id);
        Annotations.Remove(deletedAnnotation);
        await Save();
    }

    public async Task<Annotation> Update(Guid id, Annotation annotation)
    {
        Annotation updatedAnnotation = await Read(id);
        updatedAnnotation.Text = annotation.Text;
        updatedAnnotation.BookId = annotation.BookId;

        Annotations.Update(updatedAnnotation);
        await Save();

        return updatedAnnotation;
    }

    public async Task<IEnumerable<Annotation>> ReadAll()
    {
        return await Annotations.ToListAsync();
    }

    private async Task Save() => await _context.SaveChangesAsync();

    public ITransaction BeginTransaction()
    {
        var transaction = _context.Database.BeginTransaction();
        return new Transaction(transaction);
    }

    public async Task<Annotation> ReadByBookId(Guid bookId)
    {
        return await Annotations.FirstOrDefaultAsync(a => a.BookId.Equals(bookId));
    }
}
