using System;
using Microsoft.EntityFrameworkCore.Migrations;

namespace DBServer.Migrations
{
    public partial class ChangedCompleteShift : Migration
    {
        protected override void Up(MigrationBuilder migrationBuilder)
        {
            migrationBuilder.DropColumn(
                name: "Status",
                table: "CompleteShifts");

            migrationBuilder.AddColumn<DateTime>(
                name: "checkIn",
                table: "CompleteShifts",
                nullable: false,
                defaultValue: new DateTime(1, 1, 1, 0, 0, 0, 0, DateTimeKind.Unspecified));

            migrationBuilder.AddColumn<DateTime>(
                name: "checkOut",
                table: "CompleteShifts",
                nullable: false,
                defaultValue: new DateTime(1, 1, 1, 0, 0, 0, 0, DateTimeKind.Unspecified));
        }

        protected override void Down(MigrationBuilder migrationBuilder)
        {
            migrationBuilder.DropColumn(
                name: "checkIn",
                table: "CompleteShifts");

            migrationBuilder.DropColumn(
                name: "checkOut",
                table: "CompleteShifts");

            migrationBuilder.AddColumn<bool>(
                name: "Status",
                table: "CompleteShifts",
                nullable: false,
                defaultValue: false);
        }
    }
}
