using Grpc.Net.Client;
using Ammunition.Server.Proto;
using static Ammunition.Server.Proto.Ammunition;
using Google.Protobuf.WellKnownTypes;
using System.Text.Json;

using var channel = GrpcChannel.ForAddress("https://localhost:7273");
var client = new AmmunitionClient(channel);
var response = client.GetAmmunition(new Empty());

var serializedAmmunition = JsonSerializer.Serialize(response);
Console.WriteLine(serializedAmmunition);
Console.ReadKey();