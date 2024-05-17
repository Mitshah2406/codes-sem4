def doesPageExist(page, frames,nP,nF):
    exist = False
    for i in range(0,nF):
        if(page==frames[i]):
            exist=True
            break
    
    return exist
def findFirstFutureOccurence(pages, start, end, target):
   
     for i in range(start, end):
          if(target==pages[i]):
               return i
     return 99999
def optimal(pages,nP,nF):
    hitCount=0
    frames=[]
    print(f"NF {nF} nP {nP}")
    for i in range(0,nF):
        frames.append(pages[i])
        print(f"Page {pages[i]} ==> Frames {frames} | Fault")


    for i in range(nF,nP):
        if(doesPageExist(pages[i], frames, nP,nF)):
                hitCount+=1
                print(f"Page {pages[i]} ==> Frames {frames} | HIT")
        else:
                currentOptimal = findFirstFutureOccurence(pages, i+1, nP, frames[0])
                frameIdxToBeRemoved=0

                for j in  range(1,nF):
                     newOptimal = findFirstFutureOccurence(pages, i+1,nP, frames[j])

                     if(currentOptimal<newOptimal):
                          currentOptimal=newOptimal
                          frameIdxToBeRemoved=j
                

                frames[frameIdxToBeRemoved] = pages[i]
                print(f"Page {pages[i]} ==> Frames {frames} | Fault")
    
    print(f"No of hits {hitCount}")
    print(f"No of faults {abs(hitCount-nP)}")


            

nP = int(input("Enter no of pages: "))
pages=[]
for i in range(0,nP):
    pages.append(int(input()))

nF = int(input("Enter no of frames: "))

optimal(pages,nP,nF)
