#!/usr/bin/env python
import os, os.path
compiler = 'java -ea -cp classes:/usr/local/lib/antlr-4.5-complete.jar Main'

def get_tests():
    ls = os.listdir('test')
    ls = [ s[0:-len('.tack')] for s in ls if s.endswith('.tack') ]
    ls.sort()
    return ls

total_tests = 0
total_failed = 0

for test in get_tests():
    print '---- test %s ----' % test
    success = True
    cmd = '%s test/%s.tack' % (compiler, test)
    os.system('%s > tmp/%s.err 2>&1' % (cmd, test))
    expected_err_size = os.path.getsize('test/%s.err' % test)
    actual_err_size = os.path.getsize('tmp/%s.err' % test)
    if expected_err_size == 0 and actual_err_size > 0:
        print 'expected no errors, found tmp/%s.err:' % test
        os.system('cat tmp/%s.err' % test)
        success = False
    if expected_err_size > 0 and actual_err_size == 0:
        print 'found no errors, expected test/%s.err:' % test
        os.system('cat test/%s.err' % test)
        success = False
    total_tests = total_tests + 1
    if not success:
        print 'test %s FAILED:\n  %s' % (test, cmd)
        total_failed = total_failed + 1

if 0 != total_failed:
    print '\nFAILED %d out of %d tests' % (total_failed, total_tests)
else:
    print '\nSUCCESS'
