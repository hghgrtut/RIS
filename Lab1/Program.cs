using System.Text.RegularExpressions;

Console.WriteLine(IsMatch("abcdefghijklmnopqrstuv5320736", "abcdefghijklmnopqrstuv5320736"));
Console.WriteLine(IsMatch(@"^([\w.]+)@([\w]+).[a-zA-Z]{2,5}$", "vikiabo@mail.ru"));

static bool IsMatch(string pattern, string text)
{
    var regEx = new Regex(pattern);
    return regEx.IsMatch(text);
}