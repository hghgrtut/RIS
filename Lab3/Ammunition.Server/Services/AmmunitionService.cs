using Ammunition.Server.Proto;
using Ammunition.Server.Proto.Models;
using Google.Protobuf.WellKnownTypes;
using Grpc.Core;
using static Ammunition.Server.Proto.Ammunition;

namespace Ammunition.Server.Services;

public class AmmunitionService : AmmunitionBase
{
    public override Task<AmmunitionsResponse> GetAmmunition(Empty request, ServerCallContext context)
    {
        return Task.FromResult(new AmmunitionsResponse()
        {
            Ammunition = new AmmunitionModel
            {
                Price = 12.2,
                Model = "CoolModel",
                TypeAmmunition = TypeAmmunition.Helmet
            }
        });
    }
}