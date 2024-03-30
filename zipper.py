import zipfile
ZIP_NAME = 'b2220356127'

files = [
    'Quiz2.java',
    ]

# comparision level
with zipfile.ZipFile(ZIP_NAME+'.zip', 'w') as zf:
    for file in files:
        zf.write(file)