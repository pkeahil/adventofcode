
max_values = {
    "red": 12,
    "green": 13,
    "blue": 14
}

with open("input.txt") as games_file:
    game_data = games_file.read().splitlines()

    total_possible = 0
    for game in game_data:
        game_info = game.strip().split(":")
        game_id = int(game_info[0].split(" ")[1]) # "Game <id>"
        game_possible = True
        
        game_rounds = game_info[1].strip().split(";")
        for round in game_rounds:
            cube_pulls = round.strip().split(",") # ["3 blue", "4 red"]

            for cube_pull in cube_pulls:
                cube_pull = cube_pull.strip()
                cube_number = int(cube_pull.split(" ")[0])
                cube_color = cube_pull.split(" ")[1]

                if cube_number > max_values[cube_color]:
                    game_possible = False

        total_possible += game_id if game_possible else 0

    print(total_possible)
