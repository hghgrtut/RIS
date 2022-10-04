using Microsoft.EntityFrameworkCore;

namespace Lab7.DataAccess;

public class BookDbContext : DbContext
{
    public BookDbContext(DbContextOptions options) : base(options)
    {
        
    }
    public DbSet<Book> Books { get; set; }
}