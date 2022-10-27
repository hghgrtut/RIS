using Lab7.DataAccessLayer.Transaction;
using Microsoft.EntityFrameworkCore;

namespace Lab7.DataAccess.Repositories;

public class BookRepository : IBookRepository
{
    private readonly BookDbContext _context;
    private DbSet<Book> Users => _context.Books;

    public BookRepository(BookDbContext context)
    {
        _context = context;
    }

    public async Task<Book> Create(Book user)
    {
        var createdEntity = await Users.AddAsync(user);
        await Save();
        return createdEntity.Entity;
    }

    public Task<Book> Read(Guid id)
    {
        return Users.FirstOrDefaultAsync(user => user.Id.Equals(id));
    }

    public async Task Delete(Guid id)
    {
        Book deletedUser = await Read(id);
        Users.Remove(deletedUser);
        await Save();
    }

    public async Task<Book> Update(Guid id, Book user)
    {
        Book updatedUser = await Read(id);
        updatedUser.Title = user.Title;
        updatedUser.Description = user.Description;
        
        Users.Update(updatedUser);
        await Save();

        return updatedUser;
    }

    public async Task<IEnumerable<Book>> ReadAll()
    {
        return await Users.ToListAsync();
    }

    private async Task Save() => await _context.SaveChangesAsync();

    public ITransaction BeginTransaction()
    {
        var transaction = _context.Database.BeginTransaction();
        return new Transaction(transaction);
    }

}
