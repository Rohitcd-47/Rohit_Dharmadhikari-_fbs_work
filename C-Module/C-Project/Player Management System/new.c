// Player Management System (Using malloc & realloc) with per-function sub-menus
#include <stdio.h>
#include <string.h>
#include <stdlib.h>
#include <ctype.h>

typedef struct player
{
    int jerseyno;
    char name[30];
    int runs, wickets, matches;
} player;

void loadDefaultPlayers(player**, int*);
void addnewplayer(player**, int*, int*);
int  removeplayer(player*, int*);
int  searchplayer(player*, int, int);
int  updateplayer(player*, int);
void displayplayer(player*, int);
void sortedplayers(player*, int);
void displaytop3players(player*,int);
void sortbychoice(player*,int,int);
void searchPlayerMenu(player*, int);

int main()
{
    player *players = NULL;   // dynamic pointer
    int count = 0;

    // initially allocate memory for 1 player (will expand later)
    players = (player*)malloc(sizeof(player));
    if(players == NULL)
    {
        printf("Memory allocation failed\n");
        return 1;
    }

    loadDefaultPlayers(&players, &count);

	printf("\n------------------\033[1;36m CRICKET PLAYERS MANAGEMENT SYSTEM \033[0m------------------\n\n");
    while(1)
    {
        int choice;

        printf("\n================= PLAYER MANAGEMENT SYSTEM ================\n");
        printf("1. Add New Player\n");
        printf("2. Remove Player\n");
        printf("3. Search Player\n");
        printf("4. Update Player\n");
        printf("5. Display Sorted Players\n");
        printf("6. Display ALL Players\n");
        printf("7. Display Top 3 Players\n");
        printf("8. Exit\n");
        printf("\nEnter your choice : ");

        if(scanf("%d", &choice) != 1)   
		{
		    // guard against bad input
            while(getchar()!= '\n');
            printf("Invalid input!\n");
            continue;
        }	

        switch(choice)
        {
            case 1:
            {
                int number = 0;
                addnewplayer(&players, &count, &number);
            }
            break;

            case 2:
                removeplayer(players, &count);
                break;

            case 3:
                searchPlayerMenu(players, count);
                break;

            case 4:
                updateplayer(players, count);
                break;

            case 5:
                sortedplayers(players, count);
                break;

            case 6:
                displayplayer(players, count);
                break;

            case 7:
                displaytop3players(players, count);
                break;

            case 8:
                printf("Exiting...\n");
                free(players);
                return 0;	

            default:
                printf("Invalid Choice!\n");
        }
    }
    return 0;
}


// HARDCODED PLAYERS (Using realloc)
void loadDefaultPlayers(player **players, int *count)
{
    int defaultCount = 5;

    player *temp = (player*)realloc(*players, (*count + defaultCount) * sizeof(player));
    if(temp == NULL)
    {
        printf("Memory allocation failed while loading defaults\n");
        free(*players);
        //exit(1);
    }
    *players = temp;

    (*players)[*count].jerseyno = 18;
    strcpy((*players)[*count].name, "Virat");
    (*players)[*count].runs = 12000;
    (*players)[*count].wickets = 4;
    (*players)[*count].matches = 280;
    (*count)++;

    (*players)[*count].jerseyno = 45;
    strcpy((*players)[*count].name, "Rohit");
    (*players)[*count].runs = 10000;
    (*players)[*count].wickets = 8;
    (*players)[*count].matches = 250;
    (*count)++;

    (*players)[*count].jerseyno = 93;
    strcpy((*players)[*count].name, "Bumrah");
    (*players)[*count].runs = 250;
    (*players)[*count].wickets = 350;
    (*players)[*count].matches = 160;
    (*count)++;

    (*players)[*count].jerseyno = 33;
    strcpy((*players)[*count].name, "Hardik");
    (*players)[*count].runs = 4000;
    (*players)[*count].wickets = 70;
    (*players)[*count].matches = 180;
    (*count)++;

    (*players)[*count].jerseyno = 89;
    strcpy((*players)[*count].name, "Joe Root");
    (*players)[*count].runs = 13225;
    (*players)[*count].wickets = 45;
    (*players)[*count].matches = 158;
    (*count)++;

    printf("\nDefault Players Loaded Successfully!\n");
}


// ADD PLAYER (Using realloc) with submenu
void addnewplayer(player **players, int *count, int *number)
{
    while(1)
    {
        printf("\nAdd New Player Menu:\n");
        printf("1. Add Player(s)\n");
        printf("2. Back to Main Menu\n");
        printf("3. Exit\n");
        printf("Enter your choice: ");

        int ch;
        if(scanf("%d", &ch) != 1) { while(getchar()!='\n'); printf("Invalid input!\n"); continue; }

        if(ch == 1)
        {
            printf("How many players do you want to add? ");
            if(scanf("%d", number) != 1) { while(getchar()!='\n'); printf("Invalid input!\n"); continue; }
            if(*number <= 0) { printf("Enter a positive number\n"); continue; }

            player *temp = (player*)realloc(*players, (*count + *number) * sizeof(player));
            if(temp == NULL)
            {
                printf("Memory allocation failed while adding players\n");
                free(*players);
                exit(1);
            }
            *players = temp;

            for(int i = 0; i < *number; i++)
            {
                printf("\nEnter Jersey No : ");
                scanf("%d", &(*players)[*count + i].jerseyno);

                printf("Enter Player Name : ");
                scanf(" %[^\n]", (*players)[*count + i].name);

                printf("Runs scored : ");
                scanf("%d", &(*players)[*count + i].runs);

                printf("Wickets taken : ");
                scanf("%d", &(*players)[*count + i].wickets);

                printf("Matches played : ");
                scanf("%d", &(*players)[*count + i].matches);
            }

            *count += *number;
            printf("\nPlayers added successfully!\n\n");
        }
        else if(ch == 2)
        {
            return; // back to main
        }
        else if(ch == 3)
        {
            printf("Exiting...\n");
            free(*players);
            exit(0);
        }
        else
        {
            printf("Invalid choice!\n");
        }
    }
}


// REMOVE PLAYER with submenu
int removeplayer(player* players, int* size)
{
    while(1)
    {
        printf("\nRemove Player Menu:\n");
        printf("1. Remove Player by Jersey No\n");
        printf("2. Back to Main Menu\n");
        printf("3. Exit\n");
        printf("Enter your choice: ");

        int ch;
        if(scanf("%d", &ch) != 1) { while(getchar()!='\n'); printf("Invalid input!\n"); continue; }

        if(ch == 1)
        {
            int jerseyno;
            printf("Enter Jersey No to remove: ");
            if(scanf("%d", &jerseyno) != 1) { while(getchar()!='\n'); printf("Invalid input!\n"); continue; }

            int index = searchplayer(players, *size, jerseyno);

            if(index == -1)
            {
                printf("Player Not Found!\n");
            }
            else
            {
                for(int i = index; i < *size - 1; i++)
                    players[i] = players[i + 1];

                (*size)--;
                printf("Player removed successfully!\n\n");
            }
        }
        else if(ch == 2)
        {
            return 0; // back to main
        }
        else if(ch == 3)
        {
            printf("Exiting...\n");
            free(players);
            exit(0);
        }
        else
            printf("Invalid Choice!\n");
    }
    // unreachable
    return -1;
}


// SEARCH (helper - by jersey)
int searchplayer(player* players, int size, int jerseyno)
{
    for(int i = 0; i < size; i++)
    {
        if(players[i].jerseyno == jerseyno)
            return i;
    }
    return -1;
}


// Search Player Menu (search by jersey or by name) with submenu
void searchPlayerMenu(player* players, int size)
{
    while(1)
    {
        printf("\nSearch Player Menu:\n");
        printf("1. Search By Jersey No\n");
        printf("2. Search By Name\n");
        printf("3. Back to Main Menu\n");
        printf("4. Exit\n");
        printf("Enter your choice: ");

        int ch;
        if(scanf("%d", &ch) != 1) { while(getchar()!='\n'); printf("Invalid input!\n"); continue; }

        if(ch == 1)
        {
            int jerseyno;
            printf("Enter Jersey No to search: ");
            if(scanf("%d", &jerseyno) != 1) { while(getchar()!='\n'); printf("Invalid input!\n"); continue; }

            int index = searchplayer(players, size, jerseyno);

            if(index != -1)
            {
                printf("\nPlayer Found!\n");
                printf("Name: %s\n", players[index].name);
                printf("Runs: %d\n", players[index].runs);
                printf("Wickets: %d\n", players[index].wickets);
                printf("Matches: %d\n\n", players[index].matches);
            }
            else
                printf("Player Not Found!\n");
        }
        else if(ch == 2)
        {
        	 		{
    		char name[30];
    		printf("Enter Player Name (partial allowed): ");
    		scanf(" %[^\n]", name);

    		int matchIndex[50];
    		int count = 0;

   			for(int i = 0; i < size; i++)
   	 		{
        		char p[30], n[30];
        		strcpy(p, players[i].name);
        	strcpy(n, name);

        	for(int k = 0; p[k]; k++) p[k] = tolower(p[k]);
        	for(int k = 0; n[k]; k++) n[k] = tolower(n[k]);

        	if(strstr(p, n) != NULL)
        	{
            	matchIndex[count] = i;
            	count++;
        	}
    	}

    if(count == 0)
    {
        printf("\nNo matching player found.\n");
    }
    else if(count == 1)
    {
        int i = matchIndex[0];
        printf("\nPlayer Found:\nJersey: %d | Name: %s | Runs: %d | Wickets: %d | Matches: %d\n",
               players[i].jerseyno, players[i].name,
               players[i].runs, players[i].wickets, players[i].matches);
    }
    else
    {
        printf("\nMultiple Players Found:\n");
        for(int i = 0; i < count; i++)
        {
            int idx = matchIndex[i];
            printf("%d. %s (Jersey %d)\n",
                   i + 1, players[idx].name, players[idx].jerseyno);
        }

        int ch2;
        printf("Enter your choice: ");
        scanf("%d", &ch2);

        while(ch2 < 1 || ch2 > count)
        {
            printf("Invalid choice. Enter again: ");
            scanf("%d", &ch2);
        }

        int i = matchIndex[ch2 - 1];

        printf("\nPlayer Found:\nJersey: %d | Name: %s | Runs: %d | Wickets: %d | Matches: %d\n",
               players[i].jerseyno, players[i].name,
               players[i].runs, players[i].wickets, players[i].matches);
    }
}
		}
        else if(ch == 3)
        {
            return; // back to main
        }
        else if(ch == 4)
        {
            printf("Exiting...\n");
            free(players);
            exit(0);
        }
        else
            printf("Invalid Choice!\n");
    }
}

int updateplayer(player* players, int size)
{
    int choice;
    printf("\nUPDATE PLAYER BY:\n");
    printf("1. Jersey Number\n");
    printf("2. Player Name\n");
    printf("3. Back to Main Menu\n");
    printf("4. Exit\n");
    printf("Enter your choice: ");
    scanf("%d", &choice);

    if(choice == 3) return 0;
    if(choice == 4) exit(0);

    int index = -1;

    // ======== UPDATE BY JERSEY NUMBER ========
    if(choice == 1)
    {
        int j;
        printf("Enter Jersey Number: ");
        scanf("%d", &j);

        index = searchplayer(players, size, j);
        if(index == -1)
        {
            printf("\nPlayer Not Found!\n");
            return 0;
        }
    }

    // ======== UPDATE BY NAME ========
    else if(choice == 2)
    {
        char nm[30];
        printf("Enter Player Name: ");
        scanf(" %[^\n]", nm);

        for(int i = 0; i < size; i++)
        {
            if(strcmp(players[i].name, nm) == 0)
            {
                index = i;
                break;
            }
        }

        if(index == -1)
        {
            printf("\nPlayer Not Found!\n");
            return 0;
        }
    }
    else
    {
        printf("Invalid choice!\n");
        return 0;
    }

    // ================= MULTI-UPDATE LOOP =================
    while(1)
    {
        int upd;
        printf("\nWHAT DO YOU WANT TO UPDATE?\n");
        printf("1. Jersey Number\n");
        printf("2. Runs\n");
        printf("3. Wickets\n");
        printf("4. Matches\n");
        printf("5. Update Entire Player\n");
        printf("6. Back\n");
        printf("7. Exit\n");
        printf("Enter choice: ");
        scanf("%d", &upd);

        if(upd == 6) break;     // go back
        if(upd == 7) exit(0);   // exit program

        int val, mode;

        switch(upd)
        {
            case 1:
                printf("Enter NEW Jersey Number: ");
                scanf("%d", &players[index].jerseyno);
                break;

            case 2:  // RUNS
                printf("\nRuns Update Mode:\n1. Add\n2. Replace\nEnter choice: ");
                scanf("%d", &mode);

                printf("Enter Runs: ");
                scanf("%d", &val);

                if(mode == 1)  
                    players[index].runs += val;
                else           
                    players[index].runs = val;
                break;

            case 3:  // WICKETS
                printf("\nWickets Update Mode:\n1. Add\n2. Replace\nEnter choice: ");
                scanf("%d", &mode);

                printf("Enter Wickets: ");
                scanf("%d", &val);

                if(mode == 1)  
                    players[index].wickets += val;
                else           
                    players[index].wickets = val;
                break;

            case 4:  // MATCHES
                printf("\nMatches Update Mode:\n1. Add\n2. Replace\nEnter choice: ");
                scanf("%d", &mode);

                printf("Enter Matches: ");
                scanf("%d", &val);

                if(mode == 1)  
                    players[index].matches += val;
                else           
                    players[index].matches = val;
                break;

            case 5: // UPDATE ENTIRE PLAYER
                printf("Enter NEW Player Name: ");
                scanf(" %[^\n]", players[index].name);

                printf("Enter NEW Jersey Number: ");
                scanf("%d", &players[index].jerseyno);

                printf("Enter ADD Runs: ");
                scanf("%d", &val);
                players[index].runs += val;

                printf("Enter ADD Wickets: ");
                scanf("%d", &val);
                players[index].wickets += val;

                printf("Enter ADD Matches: ");
                scanf("%d", &val);
                players[index].matches += val;
                break;

            default:
                printf("Invalid choice!\n");
        }

        printf("\nField Updated Successfully!\n");
        printf("Do you want to update something else? (1=Yes / 0=No): ");
        int cont;
        scanf("%d", &cont);

        if(cont == 0) break;
    }

    return 1;
}



// DISPLAY PLAYER with submenu
void displayplayer(player* players, int size)
{
    while(1)
    {
        printf("\nDisplay Players Menu:\n");
        printf("1. Show All Players\n");
        printf("2. Back to Main Menu\n");
        printf("3. Exit\n");
        printf("Enter your choice: ");

        int ch;
        if(scanf("%d", &ch) != 1) { while(getchar()!='\n'); printf("Invalid input!\n"); continue; }

        if(ch == 1)
        {
            if(size == 0)
            {
                printf("No players to display.\n");
            }
            else
            {
                printf("\n==========================================================================\n");
                printf("| %-10s | %-20s | %-10s | %-10s | %-10s |\n",
                       "Jersey No", "Player Name", "Runs", "Wickets", "Matches");
                printf("==========================================================================\n");

                for(int i = 0; i < size; i++)
                {
                    printf("| %-10d | %-20s | %-10d | %-10d | %-10d |\n",
                           players[i].jerseyno,
                           players[i].name,
                           players[i].runs,
                           players[i].wickets,
                           players[i].matches);
                }
                printf("==========================================================================\n\n");
            }
        }
        else if(ch == 2)
        {
            return; // back to main
        }
        else if(ch == 3)
        {
            printf("Exiting...\n");
            free(players);
            exit(0);
        }
        else
            printf("Invalid Choice!\n");
    }
}


// SORT PLAYERS BY MAX/MIN RUNS/WICKETS with submenu
void sortedplayers(player* players, int size)
{
    while(1)
    {
        if(size == 0)
        {
            printf("\nNo players to sort.\n");
            // still provide back/exit choices
        }

        printf("\n Sort Player By : \n");
        printf("1. Maximum Runs\n");
        printf("2. Minimum Runs\n");
        printf("3. Maximum Wickets\n");
        printf("4. Minimum Wickets\n");
        printf("5. Back to Main Menu\n");
        printf("6. Exit\n\n");
        printf("Enter your criteria : ");

        int choice;
        if(scanf("%d", &choice) != 1) { while(getchar()!='\n'); printf("Invalid input!\n"); continue; }

        if(choice >=1 && choice <=4)
        {
            player temp;
            for(int i = 0; i < size - 1; i++)
            {
                for(int j = i + 1; j < size; j++)
                {
                    int swap = 0;

                    if(choice == 1 && players[j].runs > players[i].runs) swap = 1;
                    else if(choice == 2 && players[j].runs < players[i].runs) swap = 1;
                    else if(choice == 3 && players[j].wickets > players[i].wickets) swap = 1;
                    else if(choice == 4 && players[j].wickets < players[i].wickets) swap = 1;

                    if(swap)
                    {
                        temp = players[i];
                        players[i] = players[j];
                        players[j] = temp;
                    }
                }
            }
            printf("\nPlayers Sorted Successfully!\n");
            // show sorted list
            printf("\n==========================================================================\n");
            printf("| %-10s | %-20s | %-10s | %-10s | %-10s |\n",
                   "Jersey No", "Player Name", "Runs", "Wickets", "Matches");
            printf("==========================================================================\n");

            for(int i = 0; i < size; i++)
            {
                printf("| %-10d | %-20s | %-10d | %-10d | %-10d |\n",
                       players[i].jerseyno,
                       players[i].name,
                       players[i].runs,
                       players[i].wickets,
                       players[i].matches);
            }
            printf("==========================================================================\n\n");
        }
        else if(choice == 5)
        {
            return; // back to main
        }
        else if(choice == 6)
        {
            printf("Exiting...\n");
            free(players);
            exit(0);
        }
        else
            printf("Invalid choice!\n");
    }
}


// TOP 3 Players with submenu
void displaytop3players(player* players,int size)
{
    while(1)
    {
        printf("\nTop 3 Players Menu:\n");
        printf("1. Display Top 3 by Runs\n");
        printf("2. Display Top 3 by Wickets\n");
        printf("3. Back to Main Menu\n");
        printf("4. Exit\n");
        printf("Enter your choice: ");

        int ch;
        if(scanf("%d", &ch) != 1) { while(getchar()!='\n'); printf("Invalid input!\n"); continue; }

        if(ch == 1 || ch == 2)
        {
            sortbychoice(players, size, ch);
            int n = (size < 3) ? size : 3;

            if(n == 0)
            {
                printf("No players to display.\n");
            }
            else
            {
                printf("\n==========================================================================\n");
                printf("| %-10s | %-20s | %-10s | %-10s | %-10s |\n",
                       "Jersey No", "Player Name", "Runs", "Wickets", "Matches");
                printf("==========================================================================\n");

                for(int i = 0; i < n; i++)
                {
                    printf("| %-10d | %-20s | %-10d | %-10d | %-10d |\n",
                           players[i].jerseyno,
                           players[i].name,
                           players[i].runs,
                           players[i].wickets,
                           players[i].matches);
                }
                printf("==========================================================================\n\n");
            }
        }
        else if(ch == 3)
        {
            return; // back to main
        }
        else if(ch == 4)
        {
            printf("Exiting...\n");
            free(players);
            exit(0);
        }
        else
            printf("Invalid choice!\n");
    }
}

void sortbychoice(player* players,int size,int choice)
{
    player temp;
    for(int i = 0; i < size - 1; i++)
    {
        for(int j = i + 1; j < size; j++)
        {
            int swap = 0;

            if(choice == 1 && players[j].runs > players[i].runs)
                swap = 1;
            else if(choice == 2 && players[j].wickets > players[i].wickets)
                swap = 1;

            if(swap)
            {
                temp = players[i];
                players[i] = players[j];
                players[j] = temp;
            }
        }
    }
    if(choice == 1)
        printf("\nTOP 3 LEADING SCORE RUNS \n");
    else if (choice == 2)
        printf("\nTOP 3 LEADING WICKETS TAKEN \n");
}