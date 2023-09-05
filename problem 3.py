# Malikah Bain - 101240163
# Mikaeli Bain - 101240164
# Marie Blais - 101223172
#Question 3

import random
class Word:
    #initialise field values
    def __init__(self,word,guessed):
        self.word = word
        self.guessed = guessed
        

    #when word undergoes transformation, remember it's orginal form   
    def rememberWord(self):
        return self.word

    #returns a string representation of the word where letters that have not yet been guessed
    def __str__(self)-> str:
        updated_word = ''.join(letter if letter in self.guessed else '_' for letter in self.word)
        return updated_word

    #adds letters to a guessed list 
    def addLetter(self,letter):
        #if we have already guessed the letter, do not append it to the list
        if letter in self.guessed:
            print("You have already guessed this letter. Please try again.\n")
            return "Already guessed"
        #otherwise append to our list
        else:
            (self.guessed).append(letter)
        #return a list
        return self.guessed

    #check if the letter is in our word
    def guessLetter(self,letter):
        if letter in self.word:
            return True
        else:
            return False

    #return true when all letters in list guessed are in word
    def win(self, guessed_word):
        #if underscore is not our guessed word, user has guessed everything
        if "_" not in guessed_word:
            print("You win!")
            #end program
            quit()
        #otherwise
        else:
            #do nothing
            pass

            

class Hangman:
    def __init__(self,n):
        self.n = n


    def __str__(self)-> str:
        head = ' O'
        body = ' |'
        arm1 = '\|'
        arm2 = '\|/'
        leg1 = '/'
        leg2 = '/ \\'

        if self.n == 0:
            return ""
        elif self.n == 1:
            return(head)
        elif self.n == 2:
            return(head+'\n'+body)
        elif self.n == 3:
            return(head+'\n'+arm1+'\n'+body)
        elif self.n == 4:
            return(head+'\n'+arm2+'\n'+body)
        elif self.n == 5:
            return(head+'\n'+arm2+'\n'+body+'\n'+leg1)
        elif self.n == 6:
            print(head+'\n'+arm2+'\n'+body+'\n'+leg2)
            return "You lose!"
        
        return self.__str__()

    def incorrectGuess(self):
        self.n= self.n+1

def main():
    arr = ['kangaroo','capybara','wombat','koala','wallaby','quokka','platypus','dingo','kookaburra']
    word = Word(random.choice(arr),[])
    guesses = 0
    guess_repeat = []
    hangman = Hangman(0)
    while True:
        letter =input("\nGuess a letter: ")
        #if inout is a letter....
        if letter.isalpha() and len(letter)==1:
            is_letter_in_word = word.guessLetter(letter)
            letter = letter.lower()
            #if the letter is in the word, add it to the guessed list
            if is_letter_in_word == True:
                letter_in_list = word.addLetter(letter)
                guess_word = word.__str__()
                print(guess_word)
                #if we have already guesssed the letter
                if letter_in_list == "Already guessed":
                    #do nothing
                    pass
                #if we have not guessed the letter yet and it exists in the word....
                else:
                    #the word should be printed when all correctly guessed letters are revealed
                    word.win(guess_word)
                incorrect_hangman = hangman.__str__()
                print(incorrect_hangman)
            else:
                #if the letter is not in the word, increment the number of incorrect guesses
                if letter in guess_repeat:
                    print("You have already guessed this letter, and it is incorrect. Please try again.\n")
                else:
                    guess_word = word.__str__()
                    print(guess_word)
                    guess_repeat.append(letter)
                    guesses +=1
                    hangman.incorrectGuess()
                    #a hangman reflecting the number of incorrect guesses should be upadted
                    incorrect_hangman = hangman.__str__()
                    #print out the word original form before underscore transformation
                    original_word = word.rememberWord()
                    #if all tries are exhausted.....
                    if incorrect_hangman == "You lose!":
                        print("The word was "+ original_word +"!\nYou lose!")
                        #end program
                        quit()
                    #if we still have enough attempts left
                    else:
                        #do nothing
                        pass
                    #print the visual hangman
                    print(incorrect_hangman)   
                
            print("Number of incorrect guesses: "+ str(guesses)+ "\nNumber of guesses left: " + str(6 - guesses))
            
        else: 
            print('Only input one 1etter')

if __name__ == '__main__':
    main()
