

namespace Lab7.Interfaces.Helpers;

public static class DbSeed
{
    public static WebApplication SeedUserDb(this WebApplication webApplication)
    {
        using IServiceScope scope = webApplication.Services.CreateScope();
        var repository = scope.ServiceProvider.GetService<IUserRepository>();

        repository.Create(new()
        {
            FirstName = "Alexander",
            LastName = "Nesterovich"
        });

        repository.Create(new()
        {
            FirstName = "Nikola",
            LastName = "Tesla"
        });

        return webApplication;
    }
}