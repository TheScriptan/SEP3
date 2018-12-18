using Microsoft.EntityFrameworkCore.Migrations;

namespace DBServer.Migrations
{
    public partial class ShiftChangeMigration : Migration
    {
        protected override void Up(MigrationBuilder migrationBuilder)
        {
            migrationBuilder.AddColumn<bool>(
                name: "Released",
                table: "Shifts",
                nullable: false,
                defaultValue: false);
        }

        protected override void Down(MigrationBuilder migrationBuilder)
        {
            migrationBuilder.DropColumn(
                name: "Released",
                table: "Shifts");
        }
    }
}
