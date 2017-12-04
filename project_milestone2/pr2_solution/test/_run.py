#!/usr/bin/env python
import os, os.path
compiler = 'java -ea -cp classes:/usr/local/lib/antlr-4.5.1-complete.jar Main'

def get_tests():
    ls = os.listdir('test')
    ls = [ s[0:-len('.tack')] for s in ls if s.endswith('.tack') ]
    ls.sort()
    return ls

def diff(f1, f2):
    rv = os.system("diff -w -I '#' -q %s %s" % (f1, f2))
    if 0 != rv:
        os.system("diff -w -I '#' %s %s" % (f1, f2))
        return False
    return True

total_tests = 0
total_failed = 0

for test in get_tests():
    print '---- test %s ----' % test
    success = True
    cmd = '%s test/%s.tack' % (compiler, test)
    os.system('%s > tmp/%s.ast 2>&1' % (cmd, test))
    success = success and diff('test/%s.ast' % test, 'tmp/%s.ast' % test)
    total_tests = total_tests + 1
    if not success:
        print 'test %s FAILED:\n  %s' % (test, cmd)
        total_failed = total_failed + 1

if 0 != total_failed:
    print '\nFAILED %d out of %d tests' % (total_failed, total_tests)
else:
    print '\nSUCCESS'
