using Microsoft.EntityFrameworkCore;

namespace Lab7.DataAccess;

public class UserDbContext : DbContext
{
  public UserDbContext(DbContextOptions options) : base(options)
  {

  }

  public DbSet<User> Users { get; set; }
}