using System.Text.RegularExpressions;

Console.WriteLine(IsMatch("abcdefghijklmnopqrstuv5320736", "abcdefghijklmnopqrstuv5320736"));
Console.WriteLine(IsMatch(@"^(0[1-9]|[12]\d|3[01])/([0][1-9]|1[0-2])/((?:1[6-9]|[2-9]\d)\d{2})$", "30/04/1675"));

static bool IsMatch(string pattern, string text)
{
    var regEx = new Regex(pattern);
    return regEx.IsMatch(text);
}