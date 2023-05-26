#include <bits/stdc++.h>
#include <map>
#include <ctime>
using namespace std;

int main()
{
    map<string, vector<string>> dataset;
    int r = 0, set = 0;
    time_t now = time(0);
    char *dt = ctime(&now);
    dataset["hi"] = {"Hey", "Hey Buddy", "Hello"};
    dataset["do you know me ?"] = {"I know you", "NO", "Sorry But I can't"};
    dataset["what is your name ?"] = {"ChatBot 3.0", "My Self ChatBot 3.0", "My Name is ChatBot 3.0"};
    dataset["what is your age ?"] = {"My age is not defined", "My age is not Calculated yet", "Sorry I can't tell may age :("};
    dataset["exit"] = {"Visit Again !!!!", "Hope our site helpful for you !!!!!", "Thank U For Using Our ChatBot !!!!!"};

    string input = "", ans = "";
    cout << "\nWelcome to ChatBot 0.3 !!!!!!\n\n";
    cout << "Enter your question below pressed Exit to Stop\n";
    while (true)
    {
        if (input == "exit")
        {
            break;
        }
        cout << "\n\nYou : ";
        getline(cin, input);
        transform(input.begin(), input.end(), input.begin(), ::tolower);
        set = 0;

        for (auto ans : dataset)
        {
            if (ans.first.find(input) <= ans.first.size())
            {
                srand(time(0));
                r = rand() % ans.second.size();
                cout << "Bot : " << dataset[ans.first][r];
                //set = 1;
                break;
            }
        }
    }

    return 0;
}
