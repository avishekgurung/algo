import re
import os
import random

# Gets all the questions from the index files and random shuffles them for a practice.

PROJECT_DIR = "/Users/300068151/projects/algo"
ALL_INDEX_FILE_NAMES = "/tmp/__abc1234.txt"
OUTPUT_FILE = PROJECT_DIR + "/src/main/resources/questions.txt"
os.system("rm -f " + ALL_INDEX_FILE_NAMES)
os.system("find " + PROJECT_DIR + " -name index.txt > " + ALL_INDEX_FILE_NAMES)


# Gets all the questions from a selected file.
def get_questions(file_name):
  question_bank = []
  file = open(file_name, "r")
  lines = file.readlines()
  question = ""
  for line in lines:
    if re.search("^[0-9]+\.", line):
      if question != "":
        question_bank.append(question)
      question = line
    else:
      question += line
  question_bank.append(question)
  file.close()
  return question_bank


question_bank = []
index_files = open(ALL_INDEX_FILE_NAMES, "r").readlines()
for index_file in index_files:
  question_bank += get_questions(index_file.strip())

# shuffling the questions
random.shuffle(question_bank)

print("Number of questions: " + str(len(question_bank)))

# Writing to new file
output_file = open(OUTPUT_FILE, "w")
for question in question_bank:
    output_file.write(question)
    output_file.write("\n")
output_file.close()
print("Output file: " + OUTPUT_FILE)


