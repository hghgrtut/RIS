using Microsoft.EntityFrameworkCore;

namespace Lab7.DataAccess;


public class AnnotationDbContext : DbContext
{
    public AnnotationDbContext(DbContextOptions<AnnotationDbContext> options) : base(options)
    {
        Database.EnsureCreated();
    }

    public DbSet<Annotation> Annotations { get; set; }
}
