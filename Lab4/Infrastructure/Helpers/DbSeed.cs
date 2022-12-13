

namespace Lab7.Interfaces.Helpers;

public static class DbSeed
{
    public static WebApplication SeedBookDb(this WebApplication webApplication)
    {
        using IServiceScope scope = webApplication.Services.CreateScope();
        var repository = scope.ServiceProvider.GetService<IBookRepository>();

        repository.Create(new()
        {
            Title = "Чистый код. Создание, анализ и рефакторинг",
            Description = "Плохой код может работать, но он будет мешать развитию проекта и компании-разработчика, требуя дополнительные ресурсы на поддержку и \"укрощение\"."
        });

        repository.Create(new()
        {
            Title = "Чистый Agile. Основы гибкости",
            Description = "Прошло почти двадцать лет с тех пор как появился Манифест Agile. Легендарный Роберт Мартин (Дядя Боб) понял, что пора стряхнуть пыль с принципов Agile, и заново рассказать о гибком подходе не только новому поколению программистов, но и специалистам из других отраслей."
        });

        return webApplication;
    }
}