var b = prompt("Enter breadth: ");
var r = prompt("Enter rows: ");
var brd = parseInt(b);
var rows = parseInt(r);
var i;
var j;
        
        
if(brd%2==0)
{
    brd--;
}
for(var row=0;row<rows;row++)
{
    for(i=0;i<brd;i++)
    {
        for(j=brd-i; j>=0; j--)
        {
            document.write("_");
        }
        for(j=0; j<(2*i+1); j++)
        {
            if(row==0 && j==0 && i==0)
            {
                document.write("*");
            }
            else
            {
                document.write("0");
            }
        }
        document.write("<br>");
    }
}
    
for(j=0;j<10;j++)
{
    for(i=0;i<brd;i++)
    {
        document.write("_");
    }
    for(i=0;i<=2;i++)
    {
        document.write("0");
    }
    document.write("<br>");
}
