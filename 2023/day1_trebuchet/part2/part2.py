number_map = {
    "one": 1,
    "two": 2,
    "three": 3,
    "four": 4,
    "five": 5,
    "six": 6,
    "seven": 7,
    "eight": 8,
    "nine": 9
}


def get_first_digit(line: str) -> int:
    first_digit_value = 0
    first_digit_index = len(line) - 1

    for number_word in number_map:
        number = str(number_map[number_word])

        if number in line and line.index(number) <= first_digit_index:
            first_digit_index = line.index(number)
            first_digit_value = number_map[number_word]
        if (number_word in line
                and line.index(number_word) <= first_digit_index):
            first_digit_index = line.index(number_word)
            first_digit_value = number_map[number_word]

    return first_digit_value


def get_last_digit(line: str) -> int:
    last_digit_index = 0
    last_digit_value = 0

    for number_word in number_map:
        number = str(number_map[number_word])

        if number in line and line.rindex(number) >= last_digit_index:
            last_digit_index = line.rindex(number)
            last_digit_value = int(number)
        if (number_word in line
                and line.rindex(number_word) >= last_digit_index):
            last_digit_index = line.rindex(number_word)
            last_digit_value = int(number)

    return last_digit_value


with open("./input.txt") as file:
    data = file.read().split("\n")
    total = 0
    for line in data:
        total += get_first_digit(line) * 10 + get_last_digit(line)

    print(total)
