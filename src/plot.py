import matplotlib.pyplot as plt

alg = {"BitonicSort": {
    4096: [],
    16384: [],
    65536: [],
    131072: [],
    262144: [],
    524288: []
}, "CombSort": {
    4096: [],
    16384: [],
    65536: [],
    131072: [],
    262144: [],
    524288: []
}, "CocktailShakerSort": {
    4096: [],
    16384: [],
    65536: [],
    131072: [],
    262144: [],
    524288: []
}, "PigeonholeSort": {
    4096: [],
    16384: [],
    65536: [],
    131072: [],
    262144: [],
    524288: []
}}

f = open('all.log', 'r')
Lines = f.readlines()

for line in Lines:
    line = line.strip()
    temp = line.split()
    if(temp[0] == "BitonicSort"):
        if(temp[1] == "4096"):
            alg["BitonicSort"][4096].append(int(temp[3]))
        elif(temp[1] == "16384"):
            alg["BitonicSort"][16384].append(int(temp[3]))
        elif(temp[1] == "65536"):
            alg["BitonicSort"][65536].append(int(temp[3]))
        elif(temp[1] == "131072"):
            alg["BitonicSort"][131072].append(int(temp[3]))
        elif(temp[1] == "262144"):
            alg["BitonicSort"][262144].append(int(temp[3]))
        elif(temp[1] == "524288"):
            alg["BitonicSort"][524288].append(int(temp[3]))
    elif(temp[0] == "CombSort"):
        if(temp[1] == "4096"):
            alg["CombSort"][4096].append(int(temp[3]))
        elif(temp[1] == "16384"):
            alg["CombSort"][16384].append(int(temp[3]))
        elif(temp[1] == "65536"):
            alg["CombSort"][65536].append(int(temp[3]))
        elif(temp[1] == "131072"):
            alg["CombSort"][131072].append(int(temp[3]))
        elif(temp[1] == "262144"):
            alg["CombSort"][262144].append(int(temp[3]))
        elif(temp[1] == "524288"):
            alg["CombSort"][524288].append(int(temp[3]))
    elif(temp[0] == "CocktailShakerSort"):
        if(temp[1] == "4096"):
            alg["CocktailShakerSort"][4096].append(int(temp[3]))
        elif(temp[1] == "16384"):
            alg["CocktailShakerSort"][16384].append(int(temp[3]))
        elif(temp[1] == "65536"):
            alg["CocktailShakerSort"][65536].append(int(temp[3]))
        elif(temp[1] == "131072"):
            alg["CocktailShakerSort"][131072].append(int(temp[3]))
        elif(temp[1] == "262144"):
            alg["CocktailShakerSort"][262144].append(int(temp[3]))
        elif(temp[1] == "524288"):
            alg["CocktailShakerSort"][524288].append(int(temp[3]))
    elif(temp[0] == "PigeonholeSort"):
        if(temp[1] == "4096"):
            alg["PigeonholeSort"][4096].append(int(temp[3]))
        elif(temp[1] == "16384"):
            alg["PigeonholeSort"][16384].append(int(temp[3]))
        elif(temp[1] == "65536"):
            alg["PigeonholeSort"][65536].append(int(temp[3]))
        elif(temp[1] == "131072"):
            alg["PigeonholeSort"][131072].append(int(temp[3]))
        elif(temp[1] == "262144"):
            alg["PigeonholeSort"][262144].append(int(temp[3]))
        elif(temp[1] == "524288"):
            alg["PigeonholeSort"][524288].append(int(temp[3]))

x_axis = [4096, 16384, 65536, 131072, 262144, 524288]
seq = [i+1 for i in range(25)]
keys = ["BitonicSort", "CombSort", "CocktailShakerSort", "PigeonholeSort"]

# Plot for same n's
for key in keys:
    for i in x_axis:
        plt.plot(seq, alg[key][i], color="blue")
        plt.ylabel("time in ms")
        plt.title(key + " " + str(i))
        plt.savefig("./graphs/" + key + "/" + str(i) + ".png")
        plt.clf()

# Plot all cases separately
count = 1
temp = []
for key in keys:
    for i in range(25):
        for x in x_axis:
            temp.append(alg[key][x][i])
        plt.plot(x_axis, temp, color="blue")
        plt.xlabel("n")
        plt.ylabel("time in ms")
        plt.title(key + " " + str(count))
        plt.savefig("./graphs/" + key + "/" + key + "_" + str(count) + ".png")
        plt.clf()
        count += 1
        temp = []
    count = 1

# Plot all cases together
temp = []
for key in keys:
    for i in range(25):
        for x in x_axis:
            temp.append(alg[key][x][i])
        plt.plot(x_axis, temp, color="blue")
        plt.xlabel("n")
        plt.ylabel("time in ms")
        plt.title(key + " " + "All Cases")
        temp = []
    plt.savefig("./graphs/" + key + "/" + key + "_all.png")
    plt.clf()

# Plot best worst and average graphs
temp = []
Best = []
Worst = []
Avg = []

for key in keys:
    for i in range(25):
        for x in x_axis:
            temp.append(alg[key][x][i])
        if(Best == [] and Avg == [] and Worst == []):
            Best = temp
            Worst = temp
            Avg = temp
        else:
            Worst = [max(x, y) for x, y in zip(Worst, temp)]
            Best = [min(x, y) for x, y in zip(Best, temp)]
            Avg = [x + y for x, y in zip(Avg, temp)]
        temp = []
    Avg = [x/25 for x in Avg]
    line_best, = plt.plot(x_axis, Best, color="green", label="Best")
    line_worst, = plt.plot(x_axis, Worst, color="red", label="Worst")
    line_avg, = plt.plot(x_axis, Avg, color="blue", label="Average")
    plt.xlabel("n [input size]")
    plt.ylabel("time in ms")
    plt.title(key + " " + "Best & Average & Worst")
    plt.legend(handles=[line_best, line_avg, line_worst])
    print(key + "\nBest:" + str(Best) + "\nAvg:" + str(Avg) + "\nWorst:" + str(Worst))
    plt.savefig("./graphs/" + key + "/" + key + "_all_w_best_worst_average.png")
    plt.clf()
    Best = []
    Worst = []
    Avg = []
