with open("input.txt") as games_file:
    games = games_file.read().splitlines()
    total_powersets = 0

    for game in games:
        game_info = game.strip().split(":")
        game_rounds = game_info[1].strip().split(";")

        min_red = min_green = min_blue = 0

        for game_round in game_rounds:
            cube_pulls = game_round.strip().split(",")  # ["3 blue", "4 red"]

            for cube_pull in cube_pulls:
                cube_pull = cube_pull.strip()
                cube_number = int(cube_pull.split(" ")[0])
                cube_color = cube_pull.split(" ")[1]

                if cube_color == "red" and cube_number > min_red:
                    min_red = cube_number
                if cube_color == "green" and cube_number > min_green:
                    min_green = cube_number
                if cube_color == "blue" and cube_number > min_blue:
                    min_blue = cube_number

        powerset_thisgame = min_red * min_green * min_blue
        total_powersets += powerset_thisgame

    print(total_powersets)
