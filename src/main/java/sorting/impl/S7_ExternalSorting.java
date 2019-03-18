package sorting.impl;

public class S7_ExternalSorting {
}
/**
 * Problem statement: A disc has a file of size 1000 MB. Our machine has a memory of size 100MB.
 * We have to sort this file and store back in the disc.
 *
 * Challenges: We cannot load this huge input file and sort it because its size exceeds our memory.
 *
 * Solution: We use a concept of external sorting which will sort the data and store the result in a
 * new file in the disc. (The disc space is huge).
 *
 * We will divide our memory of 100MB into input and output buffers. We read data from input buffers
 * whereas we write data into output buffers. Let us choose 7 input buffers each of size 10MB. Let
 * us choose one output buffer of size 30MB. (These values are adjustable, we can choose 9 input
 * buffers of size 10MB and one output buffer of size 10mb). We will be reading data from these
 * input buffers going forward and will write our result in our single output buffer.
 *
 * Now that we have made a decision to create 7 input buffers. Before the above step of creating
 * the buffers, we will have to divide the input file into 7 smaller files. That will make each file
 * of size 140Mb each. We will read first 100Mb from a file ( we cannot read more than 100Mb as
 * its our memory limit), sort it using any efficient sort algo like quick sort and store it in a
 * file with name A.txt. We will then fetch next 40Mb from a file, sort it and store in the same
 * file A.txt. We now have our first sorted chunked file A.txt. Likewise, we will create other six
 * sorted chunks B.txt, C.txt, D.txt, E.txt, F.txt and G.txt. We have 7 sorted chunks of file in our
 * disc.
 *
 * We will now create 7 buffers as discussed each of size 10Mb. Let them be as a,b,c,d,e,f and g.
 * The buffer 'a' loads data of size 10Mb from file A.txt. Likewise b loads from B.txt and so on.
 * We will now perform k way merge and store the result in the output.
 *
 * 7-way merge procedure: Let ai,bi,ci,di,ei and fi be the pointers(or index) that points to the
 * starting element of the buffers a,b,c,d,e and f respectively. Now we compare the elements pointed
 * by these pointers or index. If the element pointed by bi is the lowest, then we put that
 * element of buffer b in the output buffer and make bi point to next element. We will repeat this
 * step of comparision until our output buffer is full.
 *
 * NOTE: We cannot merge one whole buffer into another and then with other buffers. This will
 * give erroneous result as there are many records that these buffers has to fetch from their files.
 *
 * Once the output buffer is full, we write this buffer in output file. During the process if any
 * input buffer gets exhausted then we will have to load next 10Mb of elements from their
 * corresponding file in the disc. This process is repeated until all the files are exhausted and
 * we have a sorted output file in the disc.
 *
 * NOTE: We can reduce the input buffers size and increase the output buffer at our convenience.
 * If there are restrictions like big sized data can be easily written into disc then we can keep
 * the size of output buffer huge. It all depends on the scenario.
 */
