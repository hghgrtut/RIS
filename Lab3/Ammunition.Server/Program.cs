

using Ammunition.Server.Services;

var builder = WebApplication.CreateBuilder(args);
{
    builder.Services.AddGrpc();
}

var app = builder.Build();
{
    app.MapGrpcService<AmmunitionService>();
    app.Run();
}

