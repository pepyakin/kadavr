import os

dstdir = 'classes/org/knott/kadavr'

def disasmdir(dstdir):
    failed = []
    for file in os.listdir(dstdir):
        dstfile = dstdir + '/' + file
        if os.path.isfile(dstfile):
            if os.system('java -jar kadavr-1.0-SNAPSHOT.jar ' + dstfile) != 0:
                failed.append(dstfile)
        else:
            failed.extend(disasmdir(dstfile))
    return failed


print disasmdir(dstdir)