using Microsoft.EntityFrameworkCore;

namespace Lab7.DataAccess.Repositories;

public class UserRepository : IUserRepository
{
    private readonly UserDbContext _context;
    private DbSet<User> Users => _context.Users;

    public UserRepository(UserDbContext context)
    {
        _context = context;
    }

    public async Task<User> Create(User user)
    {
        var createdEntity = await Users.AddAsync(user);
        await Save();
        return createdEntity.Entity;
    }

    public Task<User> Read(Guid id)
    {
        return Users.FirstOrDefaultAsync(user => user.Id.Equals(id));
    }

    public async Task Delete(Guid id)
    {
        User deletedUser = await Read(id);
        Users.Remove(deletedUser);
        await Save();
    }

    public async Task<User> Update(Guid id, User user)
    {
        User updatedUser = await Read(id);
        updatedUser.FirstName = user.FirstName;
        updatedUser.LastName = user.LastName;
        
        Users.Update(updatedUser);
        await Save();

        return updatedUser;
    }

    public async Task<IEnumerable<User>> ReadAll()
    {
        return await Users.ToListAsync();
    }

    private async Task Save() => await _context.SaveChangesAsync();
    
}
